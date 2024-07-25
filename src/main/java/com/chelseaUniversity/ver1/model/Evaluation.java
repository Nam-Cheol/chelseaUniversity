package com.chelseaUniversity.ver1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {

	private Integer studentId;
	private Integer subjectId;
	private Integer answer1;
	private Integer answer2;
	private Integer answer3;
	private Integer answer4;
	private Integer answer5;
	private Integer answer6;
	private Integer answer7;
	private String suggestions;
	private String subjectName;

	public float getTotalScore() {
		float score = Math.round(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7);

		return score;
	}

}
