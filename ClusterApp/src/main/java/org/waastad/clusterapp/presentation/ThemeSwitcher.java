/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Named(value = "themeSwitcher")
@SessionScoped
public class ThemeSwitcher implements Serializable {

    private static final long serialVersionUID = -8227853943342695164L;
    private Map<String, String> themes;
    private String theme;
    /**
     * Creates a new instance of ThemeSwitcher
     */
    public ThemeSwitcher() {
    }

    @PostConstruct
    public void init(){
        setTheme("cupertino");
        setThemes(new TreeMap<String, String>());
        getThemes().put("Aristo", "aristo");
        getThemes().put("Black-Tie", "black-tie");
        getThemes().put("Blitzer", "blitzer");
        getThemes().put("Bluesky", "bluesky");
        getThemes().put("Bootstrap", "bootstrap");
        getThemes().put("Casablanca", "casablanca");
        getThemes().put("Cupertino", "cupertino");
        getThemes().put("Dark-Hive", "dark-hive");
        getThemes().put("Dot-Luv", "dot-luv");
        getThemes().put("Eggplant", "eggplant");
        getThemes().put("Excite-Bike", "excite-bike");
        getThemes().put("Flick", "flick");
        getThemes().put("Glass-X", "glass-x");
        getThemes().put("Hot-Sneaks", "hot-sneaks");
        getThemes().put("Humanity", "humanity");
        getThemes().put("Le-Frog", "le-frog");
        getThemes().put("Midnight", "midnight");
        getThemes().put("Mint-Choc", "mint-choc");
        getThemes().put("Overcast", "overcast");
        getThemes().put("Pepper-Grinder", "pepper-grinder");
        getThemes().put("Redmond", "redmond");
        getThemes().put("Rocket", "rocket");
        getThemes().put("Sam", "sam");
        getThemes().put("Smoothness", "smoothness");
        getThemes().put("South-Street", "south-street");
        getThemes().put("Start", "start");
        getThemes().put("Sunny", "sunny");
        getThemes().put("Swanky-Purse", "swanky-purse");
        getThemes().put("Trontastic", "trontastic");
        getThemes().put("UI-Darkness", "ui-darkness");
        getThemes().put("UI-Lightness", "ui-lightness");
        getThemes().put("Vader", "vader");
    }
    
    public void changeTheme(String t){
        setTheme(t);
    }
    /**
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @return the themes
     */
    public Map<String, String> getThemes() {
        return themes;
    }

    /**
     * @param themes the themes to set
     */
    public void setThemes(Map<String, String> themes) {
        this.themes = themes;
    }

}
