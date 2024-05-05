package roomescape.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import roomescape.exception.CustomException;

class InputValidatorTest {

    @DisplayName("null 값이 들어올 경우 예외로 처리한다.")
    @Test
    void validateNotNull() {
        Integer arg = null;
        Assertions.assertThatThrownBy(() -> InputValidator.validateNotNull(arg))
                .isInstanceOf(CustomException.class)
                .hasMessage("null은 입력할 수 없습니다.");
    }

    @DisplayName("빈 문자열이 들어올 경우 예외로 처리한다.")
    @Test
    void validateNotEmpty() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateNotEmpty(""))
                .isInstanceOf(CustomException.class)
                .hasMessage("빈 문자열은 입력할 수 없습니다.");
    }
}
