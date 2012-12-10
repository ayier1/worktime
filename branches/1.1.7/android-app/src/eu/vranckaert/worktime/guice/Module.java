/*
 * Copyright 2012 Dirk Vranckaert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.vranckaert.worktime.guice;

import eu.vranckaert.worktime.dao.CommentHistoryDao;
import eu.vranckaert.worktime.dao.ProjectDao;
import eu.vranckaert.worktime.dao.TaskDao;
import eu.vranckaert.worktime.dao.TimeRegistrationDao;
import eu.vranckaert.worktime.dao.WidgetConfigurationDao;
import eu.vranckaert.worktime.dao.impl.CommentHistoryDaoImpl;
import eu.vranckaert.worktime.dao.impl.ProjectDaoImpl;
import eu.vranckaert.worktime.dao.impl.TaskDaoImpl;
import eu.vranckaert.worktime.dao.impl.TimeRegistrationDaoImpl;
import eu.vranckaert.worktime.dao.impl.WidgetConfigurationDaoImpl;
import eu.vranckaert.worktime.service.BackupService;
import eu.vranckaert.worktime.service.CommentHistoryService;
import eu.vranckaert.worktime.service.ExportService;
import eu.vranckaert.worktime.service.ProjectService;
import eu.vranckaert.worktime.service.TaskService;
import eu.vranckaert.worktime.service.TimeRegistrationService;
import eu.vranckaert.worktime.service.impl.CommentHistoryServiceImpl;
import eu.vranckaert.worktime.service.impl.DatabaseFileBackupServiceImpl;
import eu.vranckaert.worktime.service.impl.ExportServiceImpl;
import eu.vranckaert.worktime.service.impl.ProjectServiceImpl;
import eu.vranckaert.worktime.service.impl.TaskServiceImpl;
import eu.vranckaert.worktime.service.impl.TimeRegistrationServiceImpl;
import eu.vranckaert.worktime.service.ui.StatusBarNotificationService;
import eu.vranckaert.worktime.service.ui.WidgetService;
import eu.vranckaert.worktime.service.ui.impl.StatusBarNotificationServiceImpl;
import eu.vranckaert.worktime.service.ui.impl.WidgetServiceImpl;
import roboguice.config.AbstractAndroidModule;

public class Module extends AbstractAndroidModule {
    private static final String LOG_TAG = Module.class.getSimpleName();

    @Override
    protected void configure() {
        bindDaos();
        bindServices();
    }

    private void bindDaos() {
        bind(TimeRegistrationDao.class).to(TimeRegistrationDaoImpl.class);
        bind(ProjectDao.class).to(ProjectDaoImpl.class);
        bind(TaskDao.class).to(TaskDaoImpl.class);
        bind(CommentHistoryDao.class).to(CommentHistoryDaoImpl.class);
        bind(WidgetConfigurationDao.class).to(WidgetConfigurationDaoImpl.class);
    }

    private void bindServices() {
        bind(ProjectService.class).to(ProjectServiceImpl.class);
        bind(TimeRegistrationService.class).to(TimeRegistrationServiceImpl.class);
        bind(TaskService.class).to(TaskServiceImpl.class);
        bind(CommentHistoryService.class).to(CommentHistoryServiceImpl.class);
        bind(BackupService.class).to(DatabaseFileBackupServiceImpl.class);
        bind(ExportService.class).to(ExportServiceImpl.class);
        //UI services
        bind(WidgetService.class).to(WidgetServiceImpl.class);
        bind(StatusBarNotificationService.class).to(StatusBarNotificationServiceImpl.class);
    }
}