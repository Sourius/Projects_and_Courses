<?php
	defined('DS') ? null : define('DS', '/');
	defined('SITE_ROOT') ? null : define('SITE_ROOT', DS.'php_rest_api');
	defined('INC_PATH') ? null: define('INC_PATH', '../..'.DS.SITE_ROOT.DS.'includes');
	defined('CORE_PATH') ? null: define('CORE_PATH', '../..'.DS.SITE_ROOT.DS.'core');

	//load include files
	require_once(INC_PATH.DS.'config.php');

	//load core files
	require_once(CORE_PATH.DS.'post.php');
	require_once(CORE_PATH.DS.'category.php');
?>