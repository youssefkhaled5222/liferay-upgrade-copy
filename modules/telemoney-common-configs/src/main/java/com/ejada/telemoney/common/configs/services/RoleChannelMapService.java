package com.ejada.telemoney.common.configs.services;

import java.util.List;
import java.util.Set;

public interface RoleChannelMapService {
    Set<String> getChannelsByRole(List<String> roles);
}