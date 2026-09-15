package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Themes;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ThemesMapper {
    private static final Log LOG = LogFactoryUtil.getLog(ThemesMapper.class);

    private ThemesMapper() {
    }

    public static void copyDraftToOriginal(Themes source, Themes target) {
        LOG.info("========== Mapping Themes from draft to original ==========");

        target.setChannelId(source.getChannelId());
        target.setThemeEnName(source.getThemeEnName());
        target.setThemeArName(source.getThemeArName());
        target.setDarkTheme(source.getDarkTheme());
        target.setPrimaryColors(source.getPrimaryColors());
        target.setSecondaryColors(source.getSecondaryColors());
        target.setNeutralColors(source.getNeutralColors());
        target.setSuccessColors(source.getSuccessColors());
        target.setErrorColors(source.getErrorColors());
        target.setWarningColors(source.getWarningColors());
        target.setSupportColors(source.getSupportColors());
        target.setGradientColors(source.getGradientColors());
        target.setSplashBg(source.getSplashBg());
        target.setSplashAnimation(source.getSplashAnimation());
        target.setHeaderBg(source.getHeaderBg());
        target.setBalanceBg(source.getBalanceBg());
        target.setDefaultTheme(source.getDefaultTheme());

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
