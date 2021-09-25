package org.sklsft.demo.populator.command.organizations;

import java.util.Arrays;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringToObjectConverter;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.sklsft.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.sklsft.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * auto generated view command class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Component
public class OrganizationCertificationCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(OrganizationCertificationCommand.class);

@Inject
private OrganizationService organizationService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<OrganizationCertificationForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<OrganizationCertificationForm>(OrganizationCertificationForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<OrganizationCertificationForm>(OrganizationCertificationForm.class);
}
for (Object[] args:arguments.getArguments()) {
String message = "execute organizationService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
OrganizationCertificationForm organizationCertificationForm = mapper.mapFrom(new OrganizationCertificationForm(), Arrays.copyOfRange(args,1,args.length));

String arg0 = arguments.isArgumentsTyped()?(String)args[0]:(String)(StringToObjectConverter.getObjectFromString((String)args[0], String.class));
OrganizationFullView organizationFullView = organizationService.find(arg0);

this.organizationService.saveOrganizationCertification(organizationFullView.getId(), organizationCertificationForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
