create table AppEnvironment (
	environmentId LONG not null primary key,
	environmentName VARCHAR(75),
	channelId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusDate DATE null,
	uuid_ VARCHAR(75) null,
	originalEntityId LONG,
	entityResourceId LONG,
	version INTEGER,
	workflowAction VARCHAR(75) null
);

create index IX_AppEnvironment_channelId on AppEnvironment (channelId);
create index IX_AppEnvironment_entityResourceId on AppEnvironment (entityResourceId);
create index IX_AppEnvironment_channelId_status on AppEnvironment (channelId, status);