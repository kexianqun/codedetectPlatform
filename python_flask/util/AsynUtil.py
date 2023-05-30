from concurrent.futures import ThreadPoolExecutor

executor = ThreadPoolExecutor(5)


def async_execute_func(func, args):
    executor.submit(func, args)
    return True
