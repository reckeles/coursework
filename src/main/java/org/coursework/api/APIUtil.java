package org.coursework.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.coursework.model.KanboardMethods;
import org.coursework.model.base.BaseRequestBody;
import org.coursework.model.base.BaseResponse;
import org.coursework.model.user.User;
import org.coursework.model.user.UserId;
import org.coursework.utils.ObjectPrinter;

import static org.coursework.model.KanboardMethods.CREATE_USER;

public class APIUtil {

    public static <T, V> T sendGetRequest(KanboardMethods method, V params, Class<T> toValueTypeRef){
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base);

        BaseResponse<T> answer = response.getBody().as(BaseResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                answer.getResult(),
                toValueTypeRef
        );
    }

    public static <V> Boolean sendRemoveRequest(KanboardMethods method, V params){
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base);

        BaseResponse<Boolean> answer = response.getBody().as(BaseResponse.class);
        return answer.getResult();
    }

    public static <V> Boolean sendRemoveRequest(KanboardMethods method, V params, User user){
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);

        Response response = RequestSender.sendRequest(base, user);

        BaseResponse<Boolean> answer = response.getBody().as(BaseResponse.class);
        return answer.getResult();
    }

    public static <T, V> T sendCreateRequest(KanboardMethods method, V params){
        BaseRequestBody<V> base = new BaseRequestBody<>(method.getMethod(), method.getId(), params);
        ObjectPrinter.print(base);

        Response response = RequestSender.sendRequest(base);
        ObjectPrinter.print(response);

        BaseResponse<?> answer = response.getBody().as(BaseResponse.class);
        ObjectPrinter.print(answer.getResult());
        var result = answer.getResult();
        if (result instanceof Boolean || result == null){
            return null;
        } else {
            return (T) result;
        }
    }
}
