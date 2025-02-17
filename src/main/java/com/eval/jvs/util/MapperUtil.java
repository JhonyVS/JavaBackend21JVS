package com.eval.jvs.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ModelMapper modelMapper;


    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass){

        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .toList();
    }

    public <S, T> T map(S source, Class<T> targetClass){

        return modelMapper.map(source, targetClass);
    }

}
