package test.axios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;

	@PostMapping
	public ResponseEntity post(@RequestBody TodoRequestDto req) {
		System.out.println(req.text());
		System.out.println(req.done());

		Long savedId = todoService.post(req);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedId);
	}

	@GetMapping
	public ResponseEntity gets() {
		List<TodoResponseDto> responses = todoService.gets();

		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
}
