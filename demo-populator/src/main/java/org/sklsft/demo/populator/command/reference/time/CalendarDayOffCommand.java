package org.sklsft.demo.populator.command.reference.time;

import java.util.Arrays;

import org.sklsft.commons.mapper.impl.DbObjectToObjectConverter;
import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringToObjectConverter;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.reference.time.CalendarService;
import org.sklsft.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.reference.time.views.full.CalendarFullView;
import org.sklsft.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.sklsft.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated view command class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Component
public class CalendarDayOffCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CalendarDayOffCommand.class);

@Autowired
private CalendarService calendarService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<CalendarDayOffForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<CalendarDayOffForm>(CalendarDayOffForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<CalendarDayOffForm>(CalendarDayOffForm.class);
}
for (Object[] args:arguments.getArguments()) {
String message = "execute calendarService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CalendarDayOffForm calendarDayOffForm = mapper.mapFrom(new CalendarDayOffForm(), Arrays.copyOfRange(args,1,args.length));

String arg0 = arguments.isArgumentsTyped()?(String)(DbObjectToObjectConverter.getObjectFromDbObject(args[0], String.class)):(String)(StringToObjectConverter.getObjectFromString((String)args[0], String.class));
CalendarFullView calendarFullView = calendarService.find(arg0);

this.calendarService.saveCalendarDayOff(calendarFullView.getId(), calendarDayOffForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
