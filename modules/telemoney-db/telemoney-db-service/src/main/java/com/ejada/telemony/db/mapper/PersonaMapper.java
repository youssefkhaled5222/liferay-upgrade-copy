package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PersonaMapper {
    private static final Log LOG = LogFactoryUtil.getLog(PersonaMapper.class);

    private PersonaMapper() {
    }

    public static void copyDraftToOriginal(Persona source, Persona target) {
        LOG.info("========== Mapping Persona from draft to original ==========");

        target.setChannelId(source.getChannelId());
        target.setDarkThemeId(source.getDarkThemeId());
        target.setLightThemeId(source.getLightThemeId());
        target.setName(source.getName());
        target.setStartAge(source.getStartAge());
        target.setEndAge(source.getEndAge());
        target.setNationality(source.getNationality());
        target.setCustomerSegment(source.getCustomerSegment());
        target.setPersonaStatus(source.getPersonaStatus());
        target.setSector(source.getSector());
        target.setMinIncome(source.getMinIncome());
        target.setMaxIncome(source.getMaxIncome());
        target.setDescription(source.getDescription());
        target.setGender(source.getGender());
        target.setPriority(source.getPriority());
        target.setDateFrom(source.getDateFrom());
        target.setDateTo(source.getDateTo());
        target.setDefaultPersona(source.getDefaultPersona());

        target.setGroupId(source.getGroupId());
        target.setCompanyId(source.getCompanyId());
        target.setUserId(source.getUserId());
        target.setUserName(source.getUserName());
        target.setModifiedDate(source.getModifiedDate());

        target.setStatus(source.getStatus());
        target.setStatusByUserId(source.getStatusByUserId());
        target.setStatusByUserName(source.getStatusByUserName());
        target.setStatusDate(source.getStatusDate());
    }
    }
