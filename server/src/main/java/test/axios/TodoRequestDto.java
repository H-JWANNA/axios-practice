package test.axios;

public record TodoRequestDto(
	String text,
	Boolean done
) {
	public Todo toEntity() {
		return Todo.builder()
			.text(this.text)
			.done(this.done)
			.build();
	}
}
