package com.java.jdk21VirtualThreads.httpBinOrgExample;

import java.io.InputStream;
import java.net.URI;

public class NetworkCaller {
    private final String callName;
    public NetworkCaller(String callName){
        this.callName = callName;
    }

    public String makeCall(int secs) throws Exception{
        System.out.println(callName+" begin call "+Thread.currentThread());

        try {
            URI uri = new URI("http://httpbin.org/delay/"+secs);
            try(InputStream inputStream = uri.toURL().openStream()) {
                return new String(inputStream.readAllBytes());
            }
        }finally {
            System.out.println(callName+" end call "+Thread.currentThread());
        }

    }
}
