package org.coursework.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.coursework.model.KanboardMethods;
import org.coursework.model.Authorization;
import org.coursework.model.base.BaseRequestBody;
import org.coursework.model.base.BaseResponse;
import org.coursework.utils.ObjectPrinter;

public class APIUtil {

    public static <T, V> T sendGetRequest(KanboardMethods method, V params, Class<T> toValueTypeRef, Authorization authorization) {
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseResponse<T> answer = response.getBody().as(BaseResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                answer.getResult(),
                toValueTypeRef
        );
    }

    public static <V> Boolean sendRemoveRequest(KanboardMethods method, V params, Authorization authorization) {
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseResponse<Boolean> answer = response.getBody().as(BaseResponse.class);
        return answer.getResult();
    }

    public static <T, V> T sendCreateRequest(KanboardMethods method, V params, Authorization authorization) {
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseResponse<?> answer = response.getBody().as(BaseResponse.class);
        var result = answer.getResult();
        if (result instanceof Boolean || result == null) {
            throw new RuntimeException("Item wasn't created. Create Request failed. Status code: " + response.getStatusCode() + " Body: " + response.getBody().print());
        } else {
            return (T) result;
        }
    }
}
