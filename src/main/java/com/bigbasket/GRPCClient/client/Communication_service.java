/*Verified with server for jmeter
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bigbasket.GRPCClient.client;

import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.helloworld.CommunicationGrpc;
import io.grpc.examples.helloworld.CommunicationRequest;
import io.grpc.examples.helloworld.CommunicationGrpc.CommunicationBlockingStub;
import io.grpc.examples.helloworld.CommunicationResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class Communication_service {
	private CommunicationResponse response;
	private CommunicationRequest request;
	private CommunicationBlockingStub stub;
	private static ManagedChannel channel;
	public static boolean getResult;

	private static final Logger logger = Logger.getLogger(Communication_service.class.getName());

	public Communication_service(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().intercept(new TraceIdClientInterceptor())
				.build();
		stub = CommunicationGrpc.newBlockingStub(channel);
	}

	public static void shutdown() {
		try {
			channel.shutdown().awaitTermination(3, TimeUnit.SECONDS);
			channel.shutdownNow();

		} catch (InterruptedException e) {
			logger.info("Problem in channel shutdown in InterruptedException ");
			e.getMessage();
			channel.shutdown();
		} catch (Exception e) {
			logger.info("Problem in channel shutdown in Exception ");
			e.getMessage();
			e.printStackTrace();
			channel.shutdownNow();
		}
	}

	public CommunicationResponse CommunicationCall() {
		Context.current().withValue(Constant.TRACE_ID_CTX_KEY, "f").run(() -> {
			try {
				request = CommunicationRequest.newBuilder()
						.setBbsign("99f1e07b5a5adde0311790bfdb6d41d4807163ee006af3aecaa08f6d4a93e392:bWVtYmVyX2lk")
						.setChannel("unified").setCommunicationType("order_place").setDataMap(getJSON_Body()).build();
				response = stub.communicationRequestHandler(request);
				logger.info("\n Request -> " + request + "\n Response -> " + response);
			} catch (StatusRuntimeException e) {
				logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
				e.getMessage();
				return;

			}
		});
		return response;
	}

	private String getJSON_Body() {
		JsonParser parser = new JsonParser();
		try {
			return parser
					.parse(new JsonReader(
							new FileReader(System.getProperty("user.dir") + "//src//main//resources//order.json")))
					.toString();
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in reading Data map");
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		try {
			String host = System.getProperty("host");
			int port = Integer.parseInt((System.getProperty("port")).replaceAll("[\\D]", ""));
			Communication_service cs = new Communication_service(host, port);
			cs.CommunicationCall();
			System.out.println(cs.response);
			String res = "" + cs.response;
			if (res.contains("queued"))
				getResult = true;
			else
				getResult = false;
		}
			catch(Exception e) {
				logger.log(Level.SEVERE, "RPC failed due to some error");
			}
		finally {
			shutdown();
		}
	}
}
