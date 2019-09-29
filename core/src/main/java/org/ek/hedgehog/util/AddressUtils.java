package org.ek.hedgehog.util;

import io.netty.util.NetUtil;

import java.net.InetSocketAddress;

public final class AddressUtils {

    public static long ipv4ToLong(String ipv4) {
        if (NetUtil.isValidIpV4Address(ipv4)) {
            long ips = 0L;
            String[] numbers = ipv4.split("\\.");
            for (int i = 0; i < 4; ++i) {
                ips = ips << 8 | Integer.parseInt(numbers[i]);
            }
            return ips;
        } else {
            throw new IllegalArgumentException(ipv4 + " is not a valid IPv4 address");
        }
    }

    public static long addressToLong(String ipv4, int port) {
        return ipv4ToLong(ipv4) << 16 + port;
    }

    public static String longToIpv4(long ipLong) {
        String addr = "";
        for (int i = 3; i >= 0; i--) {
            addr += String.valueOf((ipLong & 0xff));
            if (i != 0) {
                addr += ".";
            }
            ipLong = ipLong >> 8;
        }
        return addr;
    }

    public InetSocketAddress longToAddress(long addressLong) {
        return new InetSocketAddress(longToIpv4(addressLong >> 16), (int) (addressLong & 0xFFFF));
    }


}
