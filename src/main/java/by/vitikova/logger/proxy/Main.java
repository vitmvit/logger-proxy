package by.vitikova.logger.proxy;

import by.vitikova.logger.proxy.service.CatVoice;
import by.vitikova.logger.proxy.service.impl.CatVoiceImp;
import by.vitikova.logger.proxy.service.proxy.CatProxy;

public class Main {

    public static void main(String[] args) {
        CatVoice example = new CatVoiceImp();
        CatVoice loggingProxy = new CatProxy(example);

        System.out.println(loggingProxy.getMay());
        System.out.println(loggingProxy.getHissing());
        System.out.println(loggingProxy.getGrowl());
    }
}