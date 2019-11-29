package shop.triplethree.service;

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
		return clientMapper.clientInsert(client);
	}
}

