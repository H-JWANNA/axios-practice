package test.axios;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;

	public Long post(TodoRequestDto req) {
		Todo todo = req.toEntity();
		Todo savedTodo = todoRepository.save(todo);

		return savedTodo.getTodoId();
	}

	public List<TodoResponseDto> gets() {
		List<Todo> todos = todoRepository.findAll();

		return todos.stream()
			.map(TodoResponseDto::from)
			.toList();
	}
}
