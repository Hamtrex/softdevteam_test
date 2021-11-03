package com.hmsoft.softdevteam_test.controller;

import com.hmsoft.softdevteam_test.model.security.*;
import com.hmsoft.softdevteam_test.repository.security.MenuRoleRestRepository;
import com.hmsoft.softdevteam_test.repository.security.UserRestRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author hmedrano
 */
@RestController
@RequestMapping("menuController")
public class MenuController {

    private UserRestRepository userRestRepository;
    private MenuRoleRestRepository menuRoleRestRepository;

    public MenuController(
            UserRestRepository userRestRepository,
            MenuRoleRestRepository menuRoleRestRepository
    ) {
        this.userRestRepository = userRestRepository;
        this.menuRoleRestRepository = menuRoleRestRepository;
    }

    @GetMapping(path = "/menu")
    public List<Menu> getUserMenu() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> optionalUser = this.userRestRepository.findByName(authentication.getName());
        if (optionalUser.isPresent()) {
            List<Menu> menus = new ArrayList<>();
            for(Role role: optionalUser.get().getRoles()) {
                List<MenuRole> menuRoles = this.menuRoleRestRepository.findByRoleAndActiveIsTrue(role);
                for(MenuRole menuRole: menuRoles) {
                    if (menuRole.getMenu().getRoot() && menuRole.getMenu().getActive()) {
                        menus.add(menuRole.getMenu());
                    }
                }
            }
            return menus;
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
