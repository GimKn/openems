package io.openems.edge.battery.soltaro.single.versionb;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.edge.battery.soltaro.BatteryState;


@ObjectClassDefinition( //
		name = "BMS Soltaro Single Rack Version B", //
		description = "Implements the Soltaro battery rack system.")
@interface Config {
	String service_pid();

	String id() default "bms0";

	boolean enabled() default true;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus brige.")
	String modbus_id() default "modbus0";
	
	@AttributeDefinition(name = "Modbus Unit-ID", description = "The Unit-ID of the Modbus device.")
	int modbusUnitId() default 0;
	
	@AttributeDefinition(name = "Battery state", description = "Switches the battery into the given state, if default is used, battery state is set automatically")
	BatteryState batteryState() default BatteryState.DEFAULT;
	
	@AttributeDefinition(name = "Number of slaves", description = "The number of slaves in this battery rack (max. 20)", min = "1", max = "20")
	int numberOfSlaves() default 20;

	@AttributeDefinition(name = "Error Level 2 Delay", description = "Sets the delay time in seconds how long the system should be stopped after an error level 2 has occurred")
	int errorLevel2Delay() default 600;
	
	@AttributeDefinition(name = "Max Start Attempts", description = "Sets the counter how many time the system should try to start")
	int maxStartAppempts() default 5;
	
	@AttributeDefinition(name = "Max Start Time", description = "Max Time in seconds allowed for starting the system")
	int maxStartTime() default 30;
	
	@AttributeDefinition(name = "Start Not Successful Delay Time", description = "Sets the delay time in seconds how long the system should be stopped if it was not able to start")
	int startUnsuccessfulDelay() default 3600;
	
	@AttributeDefinition(name = "Watchdog", description = "Watchdog timeout in seconds")
	int watchdog() default 60;
	
	@AttributeDefinition(name = "SoC Low Alarm", description = "Sets the value for BMS SoC protection (0..100)", min="0", max="100")
	int SoCLowAlarm() default 0;
	
	@AttributeDefinition(name = "Minimal Cell Voltage Millivolt", description = "Minimal cell voltage in milli volt when system does not allow further discharging")
	int minimalCellVoltage() default 2800;
	
	@AttributeDefinition(name = "Reduce tasks", description = "Reduces read and write tasks to avoid errors")
	boolean ReduceTasks() default false;
	
	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "";
		String webconsole_configurationFactory_nameHint() default "BMS Soltaro Single Rack Version B [{id}]";
}