package com.walkertribe.ian.protocol.core.comm;

import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import com.walkertribe.ian.enums.AudioMode;
import com.walkertribe.ian.enums.ConnectionType;
import com.walkertribe.ian.protocol.AbstractPacketTester;

public class IncomingAudioPacketTest extends AbstractPacketTester<IncomingAudioPacket> {
	@Test
	public void testParse() {
		execute("core/comm/IncomingAudioPacket.txt", ConnectionType.SERVER, 2);
	}

	@Test
	public void testConstruct() {
		new IncomingAudioPacket(1);
		new IncomingAudioPacket(1, "Title", "file");
	}

	@Override
	protected void testPackets(List<IncomingAudioPacket> packets) {
		IncomingAudioPacket pkt = packets.get(0);
		Assert.assertEquals(0, pkt.getAudioId());
		Assert.assertEquals(AudioMode.INCOMING, pkt.getAudioMode());
		Assert.assertEquals("Hello", pkt.getTitle());
		Assert.assertEquals("hello.ogg", pkt.getFileName());
		pkt = packets.get(1);
		Assert.assertEquals(1, pkt.getAudioId());
		Assert.assertEquals(AudioMode.PLAYING, pkt.getAudioMode());
		Assert.assertNull(pkt.getTitle());
		Assert.assertNull(pkt.getFileName());
	}
}