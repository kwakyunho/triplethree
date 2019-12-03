package shop.triplethree.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Client;

@Mapper
public interface ClientMapper {
	//거래처(사업종류) 리스트 가져오기
	public List<Client> getLicodeList();
	
	//거래처 정보 등록
	public int clientInsert(Client client);
	
	//거래처 정보 목록가져오기
	public List<Client> getClientList();
	
	//거래처 정보 하나만 가져오기(수정.삭제할때)
	public Client getClientBycode(String code);
	
	//거래처 정보 수정하기
	public int clientUpdate(Client client);
	
}