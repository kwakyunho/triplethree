package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.triplethree.mapper.ClientMapper;
import shop.triplethree.mapper.CommonMapper;
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
		client.setWriter("id007");//세션에서 가져올 값 : 작성자 세팅
		return clientMapper.clientInsert(client);
	}
	public List<Client> getClientList(){
		List<Client> list = clientMapper.getClientList();
		return list;
	}
	
}

