package com.shekel.uart_comm_service.mapper;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import com.shekel.uart_comm_service.models.SensorData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UartMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "temperature", source = "sensorDataDto.temperature")
    @Mapping(target = "humidity", source = "sensorDataDto.humidity")
    SensorData toSensorData(SensorDataDto sensorDataDto);

    @Mapping(target = "id", source = "sensorData.id")
    @Mapping(target = "temperature", source = "sensorData.temperature")
    @Mapping(target = "humidity", source = "sensorData.humidity")
    SensorDataDto toSensorDataDto(SensorData sensorData);
}
