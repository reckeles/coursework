package org.coursework.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.coursework.api.model.KanboardMethods;
import org.coursework.api.model.Authorization;
import org.coursework.base.BaseAPIRequestBody;
import org.coursework.base.BaseAPIResponse;

public class APIUtil {

    public static <T, V> T sendGetRequest(KanboardMethods method, V params, Class<T> toValueTypeRef, Authorization authorization) {
        BaseAPIRequestBody<V> base = new BaseAPIRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseAPIResponse<T> answer = response.getBody().as(BaseAPIResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                answer.getResult(),
                toValueTypeRef
        );
    }

    public static <V> Boolean sendRemoveRequest(KanboardMethods method, V params, Authorization authorization) {
        BaseAPIRequestBody<V> base = new BaseAPIRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseAPIResponse<Boolean> answer = response.getBody().as(BaseAPIResponse.class);
        if (answer.getResult()) {
            return answer.getResult();
        } else {
            throw new RuntimeException("Item wasn't deleted");
        }
    }

    public static <T, V> T sendCreateRequest(KanboardMethods method, V params, Authorization authorization) {
        BaseAPIRequestBody<V> base = new BaseAPIRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, authorization);

        BaseAPIResponse<?> answer = response.getBody().as(BaseAPIResponse.class);
        var result = answer.getResult();
        if (result instanceof Boolean || result == null) {
            throw new RuntimeException("Item wasn't created. Create Request failed. Status code: " + response.getStatusCode() + " Body: " + response.getBody().print());
        } else {
            return (T) result;
        }
    }
}
