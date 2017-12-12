package com.madagascar.oauth.resolver;

import com.madagascar.common.Properties;
import com.madagascar.dao.UserMapper;
import com.madagascar.execption.AuthFailedException;
import com.madagascar.model.User;
import com.madagascar.oauth.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @Creator future
 * @Date 25/01/2017 13:23
 * @Desc #desc#
 * <p>     操作header数据 用户uid  token
 * @Updator $AUTHOR$
 * @UpdateTime 25/01/2017 13:23
 * @Desc $REASON$
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private final UserMapper mUserMapper;

    @Autowired
    public CurrentUserMethodArgumentResolver(UserMapper mUserMapper) {
        this.mUserMapper = mUserMapper;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String uid = (String) webRequest.getAttribute(Properties.KEY_UID, RequestAttributes.SCOPE_REQUEST);
        if (uid != null) {
            User user = mUserMapper.queryById(uid);
            if (user == null) {
                throw new AuthFailedException();
            }

            return user;
        }
        throw new MissingServletRequestPartException(Properties.KEY_UID);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(CurrentUser.class);
    }
}
