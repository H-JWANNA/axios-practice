package test.axios;

public record TodoResponseDto(
	Long id,
	String text,
	Boolean done
) {
	public static TodoResponseDto from(Todo entity) {
		return new TodoResponseDto(
			entity.getTodoId(),
			entity.getText(),
			entity.isDone());
	}
}
