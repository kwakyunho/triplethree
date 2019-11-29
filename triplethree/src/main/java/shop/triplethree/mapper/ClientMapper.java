package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Client;

@Mapper
public interface ClientMapper {
	public int clientInsert(Client client);
}