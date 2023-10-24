package test.axios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long todoId;

	@Column(name = "text", columnDefinition = "TEXT")
	String text;

	@Column(name = "done")
	boolean done;

	@Builder
	public Todo(String text, boolean done) {
		this.text = text;
		this.done = done;
	}
}
