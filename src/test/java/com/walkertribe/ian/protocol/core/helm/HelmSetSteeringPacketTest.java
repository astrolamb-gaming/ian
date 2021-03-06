package com.walkertribe.ian.protocol.core.helm;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.walkertribe.ian.enums.ConnectionType;
import com.walkertribe.ian.protocol.AbstractPacketTester;

public class HelmSetSteeringPacketTest extends AbstractPacketTester<HelmSetSteeringPacket> {
	@Test
	public void test() {
		execute("core/helm/HelmSetSteeringPacket.txt", ConnectionType.CLIENT, 2);
	}

	@Override
	protected void testPackets(List<HelmSetSteeringPacket> packets) {
		HelmSetSteeringPacket pkt = packets.get(0);
		Assert.assertEquals(0.0f, pkt.getSteering(), EPSILON);
		pkt = packets.get(1);
		Assert.assertEquals(0.7f, pkt.getSteering(), EPSILON);
	}
}