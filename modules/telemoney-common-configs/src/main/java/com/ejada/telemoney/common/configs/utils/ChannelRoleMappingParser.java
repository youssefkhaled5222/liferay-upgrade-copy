package com.ejada.telemoney.common.configs.utils;

import java.util.*;

public class ChannelRoleMappingParser {

    public static Map<String, Set<String>> parse(String[] entries) {
        Map<String, Set<String>> result = new HashMap<>();
        if (entries == null) return result;

        for (String entry : entries) {
            if (entry == null || entry.trim().isEmpty()) continue;

            int sep = entry.indexOf('=');
            if (sep <= 0 || sep == entry.length() - 1) continue;

            String roleName = entry.substring(0, sep).trim().toLowerCase();
            String valuesPart = entry.substring(sep + 1).trim();
            if (roleName.isEmpty() || valuesPart.isEmpty()) continue;

            Set<String> values = result.computeIfAbsent(roleName, k -> new HashSet<>());
            for (String value : valuesPart.split(",")) {
                String normalized = value.trim().toLowerCase();
                if (!normalized.isEmpty()) values.add(normalized);
            }
        }
        return result;
    }
}