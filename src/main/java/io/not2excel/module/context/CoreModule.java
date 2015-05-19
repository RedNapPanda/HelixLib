/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.module.context;

import io.not2excel.metadata.CoreMetadata;
import io.not2excel.module.annotation.AbstractModule;
import io.not2excel.module.annotation.ModuleInfo;
import io.not2excel.plugin.CorePlugin;
import lombok.Getter;

@AbstractModule
@ModuleInfo(id = "core", name = "Core Module")
public class CoreModule<P extends CorePlugin> implements Module {

    @Getter
    private P owner;
    private CoreMetadata<P, Object> metadata;

    public CoreModule(P owner) {
        this.owner = owner;
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    /**
     * True if metadata has been instantiated
     *
     * @return metadata exists or not
     */
    public boolean hasMetadata() {
        return metadata != null;
    }

    /**
     * Returns the metadata object for this module
     * Lazy (double locked) instantiates the metadata object if null
     *
     * @return metadata
     * @since 0.1.0
     */
    public CoreMetadata getMetadata() {
        if (metadata == null) {
            synchronized (this) {
                if (metadata == null) {
                    metadata = new CoreMetadata<>();
                }
            }
        }
        return metadata;
    }
}
