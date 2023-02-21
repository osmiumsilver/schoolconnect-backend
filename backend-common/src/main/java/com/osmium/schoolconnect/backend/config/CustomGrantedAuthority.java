//package com.osmium.schoolconnect.backend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.SpringSecurityCoreVersion;
//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObjectBuilder;
//
//import org.springframework.util.Assert;
//
//import com.eliza.tourism.ms.users.dao.model.ElizaTourismGroup;
//import com.eliza.tourism.ms.users.dao.model.Role;
///**
// * @Author
// * @Date 2023/2/5
// * @Description
// */
//
//
//@Bean
//public class CustomGrantedAuthority GrantedAuthority {///我得把Spring Security和我自己的身份系统整合啊
//
//    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
//
//    private ElizaTourismGroup group;
//
//    public CustomGrantedAuthority(ElizaTourismGroup group) {
//        Assert.notNull(group, "A granted authority group representation is required");
//        this.group = group;
//    }
//
//    @Override
//    public String getAuthority() {
//        final JsonObjectBuilder groupJsonBuilder = Json.createObjectBuilder();
//        if (!group.getRoles().isEmpty()) {
//            final JsonArrayBuilder rolesArrayBuilder = Json.createArrayBuilder();
//            for (Role role : group.getRoles()) {
//                final JsonObjectBuilder roleJsonBuilder = Json.createObjectBuilder();
//                final JsonArrayBuilder privilegesArrayBuilder = Json.createArrayBuilder();
//                role.getPrivileges().stream().map(privilege -> privilege.getName()).forEach(privilegesArrayBuilder::add);
//                roleJsonBuilder.add(role.getName(), privilegesArrayBuilder);
//                rolesArrayBuilder.add(roleJsonBuilder);
//            }
//            groupJsonBuilder.add(group.getName(), rolesArrayBuilder);
//            return groupJsonBuilder.build().toString();
//        }
//        return "";
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//
//        if (obj instanceof CustomGrantedAuthority) {
//            return group.getId().equals(((CustomGrantedAuthority) obj).group.getId());
//        }
//
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.group.getId().hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return this.group.getId().toString();
//    }
//}