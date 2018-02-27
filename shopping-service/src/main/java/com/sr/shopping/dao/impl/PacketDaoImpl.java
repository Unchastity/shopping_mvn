package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.BaseDao;
import com.sr.shopping.dao.PacketDao;
import com.sr.shopping.entity.Packet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("packetDao")
@Transactional
public class PacketDaoImpl extends BaseDaoImpl<Packet> implements PacketDao{


}
