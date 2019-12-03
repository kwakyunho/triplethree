package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.triplethree.service.ClientService;
import shop.triplethree.vo.Client;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	//거래처 정보조회 리스트
		@GetMapping("/clientList")
		public String clientList(Model model) {
			model.addAttribute("client", clientService.getClientList());
			return "/client/clientList";
		}
		
		
	//거래처 정보 수정화면 이동
	@GetMapping("/clientUpdate")
	public String clientUpdate(@RequestParam(value="code")
								String code,Model model) {
		System.out.println(code + "<--수정 할 거래처 code");
		model.addAttribute("liCode", clientService.getLicodeList());
		model.addAttribute("client", clientService.getClientBycode(code));
		return "/client/clientEdit";
	}
	
	//거래처 정보 수정
	@PostMapping("/clientUpdate")
	public String clientUpdate(Client client) {
		clientService.clientUpdate(client);
		return "redirect:/clientList";
	}
	
	
	//거래처 정보등록 화면이동 (거래처 상태가지고감)
	@GetMapping("/clientInsert")
	public String clientInsert(Model model) {
		model.addAttribute("liCode", clientService.getLicodeList());
		return "/client/clientInsert";
	}
	
	//거래처 정보 입력
	@PostMapping("/clientInsert")
	public String clientInsert(Client client) {
		System.out.println(client + "<-client");
		//코드생성 메서드 호출
		clientService.createClientCode(client);
		
		/* return "/client/clientList"; */
		return "redirect:/clientList";
	}
	
	
}
