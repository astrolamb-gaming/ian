package com.walkertribe.ian.protocol.core.setup;

import java.util.List;

import org.junit.Assert;

import com.walkertribe.ian.enums.ConnectionType;
import com.walkertribe.ian.protocol.AbstractPacketTester;
import com.walkertribe.ian.util.Version;

import org.junit.Test;

public class VersionPacketTest extends AbstractPacketTester<VersionPacket> {
	private static final Version VERSION_2_0 = new Version(2.0f);
	private static final Version VERSION_2_1_1 = new Version("2.1.1");

	@Test
	public void test() {
		execute("core/setup/VersionPacket.txt", ConnectionType.SERVER, 2);
	}

	@Override
	protected void testPackets(List<VersionPacket> packets) {
		Assert.assertEquals(VERSION_2_0, packets.get(0).getVersion());
		Assert.assertEquals(VERSION_2_1_1, packets.get(1).getVersion());
	}
}