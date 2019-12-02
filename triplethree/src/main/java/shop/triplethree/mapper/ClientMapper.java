package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Client;

@Mapper
public interface ClientMapper {
	public int clientInsert(Client client);
	
	public List<Client> getClientList();
}