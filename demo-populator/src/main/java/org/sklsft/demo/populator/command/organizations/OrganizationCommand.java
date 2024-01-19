package org.sklsft.demo.populator.command.organizations;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.sklsft.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated bean populator command class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Component
public class OrganizationCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(OrganizationCommand.class);

@Autowired
private OrganizationService organizationService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<OrganizationForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<OrganizationForm>(OrganizationForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<OrganizationForm>(OrganizationForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute organizationService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
OrganizationForm organizationForm = mapper.mapFrom(new OrganizationForm(), args);

this.organizationService.save(organizationForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
