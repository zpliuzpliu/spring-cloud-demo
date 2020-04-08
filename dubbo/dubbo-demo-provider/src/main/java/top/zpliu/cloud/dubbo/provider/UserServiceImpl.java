package top.zpliu.cloud.dubbo.provider;

import org.apache.dubbo.config.annotation.Service;
import top.zpliu.cloud.dubbo.consume.api.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean isExist(String userId) {
        return false;
    }
}
