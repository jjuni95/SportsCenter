package com.proj.sportscenter.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter //이거 두개가 귀찮다? 그럼 @Data로 쓴다.
@Setter //
@NoArgsConstructor //기본생성자 만들어줌 (필수!)
@AllArgsConstructor //파라미터가 들어있는 생성자
@EqualsAndHashCode //필수 vo 객체 안에 데이터가 동일한 경우 같은 객체로 인식
@ToString

public class QnaVo {
	private Long qnaNo; //관습상 long으로한다~.
	private String qnaQuestion;
	private String qnaAnswer;
	private String qnaWriter;
	private LocalDateTime regDate;
}
