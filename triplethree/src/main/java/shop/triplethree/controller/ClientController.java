package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.service.ClientService;
import shop.triplethree.vo.Client;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	//거래처 정보 수정
	@GetMapping("/clientEdit")
	public String ClientEdit(Model model) {
		
		return "/client/clientEdit";
	}
	//거래처 정보조회 리스트
	@GetMapping("/clientList")
	public String ClientList(Model model) {
		model.addAttribute("clientList", clientService.getClientList());
		return "/client/clientList";
	}
	
	/*
	 * //거래처 정보조회 리스트
	 * 
	 * @PostMapping("/clientList") public String getClientList(Client client) {
	 * clientService.getClientList(); return "/client/clientList"; } /
	 */
	//거래처 정보등록
	@GetMapping("/clientInsert")
	public String ClientInsert() {
		return "/client/clientInsert";
	}
	@PostMapping("/clientInsert")
	public String ClientInsert(Client client) {
		System.out.println(client + "<-client");
		//코드생성 메서드 호출
		clientService.createClientCode(client);
		/* return "/client/clientList"; */
		return "redirect:/clientList";
	}
	
	
}
