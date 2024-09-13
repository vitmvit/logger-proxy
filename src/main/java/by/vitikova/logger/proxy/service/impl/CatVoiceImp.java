package by.vitikova.logger.proxy.service.impl;

import by.vitikova.logger.proxy.annotation.Log;
import by.vitikova.logger.proxy.service.CatVoice;

/**
 * Класс {@code CatVoiceImp} реализует {@code CatVoice} и содержит
 * методы с аннотацией {@code Log} для логирования.
 */
public class CatVoiceImp implements CatVoice {

    @Log
    @Override
    public String getMay() {
        return "May!";
    }

    @Override
    public String getHissing() {
        return "Shhhhh!";
    }

    @Log
    @Override
    public String getGrowl() {
        return "Rrrrrr!";
    }
}