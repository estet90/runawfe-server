/*
 * This file is part of the RUNA WFE project.
 * 
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation; version 2.1 
 * of the License. 
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details. 
 * 
 * You should have received a copy of the GNU Lesser General Public License 
 * along with this program; if not, write to the Free Software 
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package ru.runa.report.web.action;

import java.util.List;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ru.runa.common.web.Resources;
import ru.runa.common.web.action.GrantPermisionsOnIdentifiableAction;
import ru.runa.wfe.report.ReportsSecure;
import ru.runa.wfe.security.Identifiable;
import ru.runa.wfe.security.Permission;
import ru.runa.wfe.user.User;

import com.google.common.collect.Lists;

public class GrantPermissionsOnReportsAction extends GrantPermisionsOnIdentifiableAction {

    public static final String ACTION_PATH = "/grantPermissionsOnReports";

    private static final List<Permission> PERMISSIONS = Lists.newArrayList(Permission.READ);

    @Override
    protected List<Permission> getIdentifiablePermissions() {
        return PERMISSIONS;
    }

    @Override
    protected Identifiable getIdentifiable(User user, Long identifiableId) {
        return ReportsSecure.INSTANCE;
    }

    @Override
    public ActionForward getErrorForward(ActionMapping mapping, Long identifiableId) {
        return mapping.findForward(Resources.FORWARD_FAILURE);
    }

    @Override
    public ActionForward getSuccessForward(ActionMapping mapping, Long identifiableId) {
        return mapping.findForward(Resources.FORWARD_SUCCESS);
    }
}
