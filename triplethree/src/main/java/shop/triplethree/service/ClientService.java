package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.triplethree.mapper.ClientMapper;
import shop.triplethree.vo.Client;

@Service
public class ClientService {
	@Autowired private CommonService commonService;
	@Autowired private ClientService clientService;
	@Autowired private ClientMapper clientMapper;	
	
	//인서트를 위한 Pk 코드 생성 메서드 
	public int createClientCode(Client client) {
		String code = commonService.codeGeneration("ACC_MANAGE");
		client.setCode(code);
		System.out.println(code + " : 생성된 코드");
		//작성자 세션값 세팅
		client.setWriter("${session.SID}");	
		return clientMapper.insertClient(client);
	}
	//거래처 리스트 가져오기
	public List<Client> getClientList(){
		List<Client> list = clientMapper.getClientList();
		return list;
	}
	//거래처(거래중) 리스트 가져오기
	public List<Client> getClientList2(){
		List<Client> list = clientMapper.getClientList2();
		return list;
	}
	
	//거래처 정보 하나만 (수정하기위해서 가져오는거)
	public Client getClientBycode(String code){
		Client client = clientMapper.getClientBycode(code);
		return client;
	}
	
	//거래처 사업장 종류 가져오기
	public List<Client> getLicodeList(){
		return clientMapper.getLicodeList();
	}
	
	//거래상태 가져오기
	public List<Client> getLicode2List(){
		return clientMapper.getLicode2List();
	}
	
	//거래처 정보 수정하기
	public int updateClient(Client client) {
		
		return clientMapper.updateClient(client);
	}
	
	//거래처 삭제하기
	public int deleteClient(String code) {
		return  clientMapper.deleteClient(code);
	}
	
}

