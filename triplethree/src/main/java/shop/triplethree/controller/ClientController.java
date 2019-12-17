package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.mapper.ClientMapper;
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
	//거레처 정보 상세보기
	@PostMapping("/clientDetail")
	public String goToDetail(@RequestParam(value="code",required=false)String code, Model model){
		System.out.println("controller의 거래처 코드" + code);
		model.addAttribute("client",clientService.getClientBycode(code));
		return "/client/clientDetail";
	}
		
	//거래중 거래처 정보조회 리스트
	@GetMapping("/clientList2")
	public String clientList2(Model model) {
		model.addAttribute("client2", clientService.getClientList2());
		return "/client/clientList2";
	}
		
	//거래처 정보 수정화면 이동
	@PostMapping("/goClientUpdate")
	public String clientUpdate(@RequestParam(value="code")
								String code,Model model) {
		System.out.println(code + "<--수정 할 거래처 code");
		model.addAttribute("liCode", clientService.getLicodeList());
		System.out.println(clientService.getLicodeList().toString() + "liCode 안입니다 ##");
		model.addAttribute("liCode2", clientService.getLicode2List());
		model.addAttribute("client", clientService.getClientBycode(code));
		return "/client/clientUpdate";
	}
	
	/**거래처 정보 수정처리
	 * @param client
	 * @return 
	 * */
	@PostMapping("/clientUpdate")
	public String clientUpdate(Client client, Model model) {
		clientService.updateClient(client);
		model.addAttribute("code", client.getCode());
		return "redirect:/clientList";
	}
	
	//거래처 정보삭제(상태변경)
	@PostMapping("/clientDelete")
	public String deleteClient(@RequestParam(value="code")String code,Model model) {
		System.out.println(code + "<--삭제  할 거래처 code");
		clientService.deleteClient(code);
		return "redirect:/clientList";
	}

	//거래처 정보등록 화면이동 (거래처 상태가지고감)
	@GetMapping("/clientInsert")
	public String insertClient(Model model) {
		model.addAttribute("liCode", clientService.getLicodeList());
		return "/client/clientInsert";
	}
	
	//거래처 정보 입력
	@PostMapping("/clientInsert")
	public String insertClient(Client client) {
		System.out.println("## clientInsert Code 생성 ##");
		clientService.createClientCode(client); //코드생성 메서드 createClientCode
		return "redirect:/clientList";
	}
	
	
}
