/*******************************************************************************
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.workspace.server.bootstrap;

import org.eclipse.che.api.core.websocket.commons.WebSocketMessageReceiver;
import org.eclipse.che.api.core.websocket.impl.BasicWebSocketEndpoint;
import org.eclipse.che.api.core.websocket.impl.GuiceInjectorEndpointConfigurator;
import org.eclipse.che.api.core.websocket.impl.MessagesReSender;
import org.eclipse.che.api.core.websocket.impl.WebSocketSessionRegistry;
import org.eclipse.che.api.core.websocket.impl.WebsocketIdService;

import javax.inject.Inject;
import javax.websocket.server.ServerEndpoint;

/**
 * JSON-RPC endpoint for agent installers.
 *
 * @author Max Shaposhnik (mshaposhnik@codenvy.com)
 */
@ServerEndpoint(value = InstallerEndpoint.INSTALLER_WEBSOCKET_ENDPOINT_BASE,
                configurator = GuiceInjectorEndpointConfigurator.class)
public class InstallerEndpoint extends BasicWebSocketEndpoint {

    public static final String INSTALLER_WEBSOCKET_ENDPOINT_BASE = "/installer/websocket";

    @Inject
    public InstallerEndpoint(WebSocketSessionRegistry registry,
                             MessagesReSender reSender,
                             WebSocketMessageReceiver receiver,
                             WebsocketIdService websocketIdService) {
        super(registry, reSender, receiver, websocketIdService);
    }

    @Override
    protected String getEndpointId() {
        return "installer-websocket-endpoint";
    }
}
