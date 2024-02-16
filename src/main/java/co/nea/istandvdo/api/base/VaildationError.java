package co.nea.istandvdo.api.base;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VaildationError {
    private  String field;
    private  String detail;
}
