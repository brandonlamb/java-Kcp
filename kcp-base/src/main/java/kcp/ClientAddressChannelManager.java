package kcp;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.socket.DatagramPacket;

/**
 * Created by JinMiao
 * 2019/10/16.
 */
public class ClientAddressChannelManager implements IChannelManager {

  private Map<SocketAddress, Ukcp> ukcpMap = new ConcurrentHashMap<>();

  @Override
  public Ukcp get(DatagramPacket msg) {
    return ukcpMap.get(msg.recipient());
  }

  @Override
  public void add(SocketAddress socketAddress, Ukcp ukcp) {
    ukcpMap.put(socketAddress, ukcp);
  }

  @Override
  public void remove(Ukcp ukcp) {
    ukcpMap.remove(ukcp.user().getLocalAddress());
  }

  @Override
  public Collection<Ukcp> getAll() {
    return this.ukcpMap.values();
  }
}
